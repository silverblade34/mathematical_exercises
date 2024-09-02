package alvarez.pa1.org.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import java.util.Random;
import alvarez.pa1.org.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomNumber = generateRandomNumber();
                binding.numberText.setText("Número generado: " + randomNumber);
                checkIfNumberIsAdequate(randomNumber);
            }
        });

        return root;
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }

    private void checkIfNumberIsAdequate(int number) {
        String numberStr = String.valueOf(number);
        int oddCount = 0;

        for (char c : numberStr.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (digit % 2 != 0) {
                oddCount++;
            }
        }

        if (oddCount >= 3) {
            binding.resultText.setText("Resultado: El número es adecuado para el experimento.");
        } else {
            binding.resultText.setText("Resultado: El número no es adecuado para el experimento.");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
