package alvarez.pa1.org.ui.ipaddress;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import java.util.regex.Pattern;
import alvarez.pa1.org.databinding.FragmentIpaddressBinding;


public class IpAddressFragment extends Fragment {

    private FragmentIpaddressBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        IpAddressViewModel ipAddressViewModel =
                new ViewModelProvider(this).get(IpAddressViewModel.class);

        binding = FragmentIpaddressBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ipAddress = binding.ipInput.getText().toString().trim();
                if (isValidIpAddress(ipAddress)) {
                    if (isPrivateIpAddress(ipAddress)) {
                        binding.resultText.setText("La dirección IP es válida y es privada.");
                    } else {
                        binding.resultText.setText("La dirección IP es válida y es pública.");
                    }
                } else {
                    binding.resultText.setText("La dirección IP no es válida.");
                }
            }
        });

        return root;
    }

    private boolean isValidIpAddress(String ipAddress) {
        String ipPattern =
                "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        return Pattern.matches(ipPattern, ipAddress);
    }

    private boolean isPrivateIpAddress(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        int firstOctet = Integer.parseInt(parts[0]);
        int secondOctet = Integer.parseInt(parts[1]);

        return (firstOctet == 10) ||
                (firstOctet == 172 && (secondOctet >= 16 && secondOctet <= 31)) ||
                (firstOctet == 192 && secondOctet == 168);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
