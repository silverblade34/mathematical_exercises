package alvarez.pa1.org.ui.convertbase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import alvarez.pa1.org.databinding.FragmentConvertbaseBinding;

public class ConvertBaseFragment extends Fragment {

    private FragmentConvertbaseBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ConvertBaseViewModel convertBaseViewModel =
                new ViewModelProvider(this).get(ConvertBaseViewModel.class);

        binding = FragmentConvertbaseBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hexNumber = binding.inputHex.getText().toString().trim();
                String baseString = binding.inputBase.getText().toString().trim();

                if (!hexNumber.isEmpty() && !baseString.isEmpty()) {
                    try {
                        int base = Integer.parseInt(baseString);
                        if (base < 2 || base > 36) {
                            Toast.makeText(getContext(), "Ingrese una base entre 2 y 36", Toast.LENGTH_SHORT).show();
                        } else {
                            String result = convertHexToBase(hexNumber, base);
                            binding.resultText.setText("Resultado: " + result);
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(getContext(), "Entrada inválida", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Complete todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }

    private String convertHexToBase(String hexNumber, int base) {
        int decimalValue = Integer.parseInt(hexNumber, 16);
        return Integer.toString(decimalValue, base);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
