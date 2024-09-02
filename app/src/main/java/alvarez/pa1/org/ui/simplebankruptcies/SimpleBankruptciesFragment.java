package alvarez.pa1.org.ui.simplebankruptcies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import alvarez.pa1.org.databinding.FragmentSimplebankruptciesBinding;

public class SimpleBankruptciesFragment extends Fragment {
    private FragmentSimplebankruptciesBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSimplebankruptciesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        EditText numerator1 = binding.numerator1;
        EditText denominator1 = binding.denominator1;
        EditText numerator2 = binding.numerator2;
        EditText denominator2 = binding.denominator2;
        Button addButton = binding.addButton;
        TextView resultText = binding.resultText;

        addButton.setOnClickListener(v -> addFractions(numerator1, denominator1, numerator2, denominator2, resultText));

        return root;
    }

    private void addFractions(EditText numerator1, EditText denominator1,
                              EditText numerator2, EditText denominator2,
                              TextView resultText) {
        try {
            int num1 = Integer.parseInt(numerator1.getText().toString());
            int denom1 = Integer.parseInt(denominator1.getText().toString());
            int num2 = Integer.parseInt(numerator2.getText().toString());
            int denom2 = Integer.parseInt(denominator2.getText().toString());

            int commonDenominator = denom1 * denom2;
            int newNumerator = (num1 * denom2) + (num2 * denom1);
            int gcd = gcd(newNumerator, commonDenominator);

            newNumerator /= gcd;
            commonDenominator /= gcd;

            resultText.setText("Resultado: " + newNumerator + "/" + commonDenominator);

        } catch (NumberFormatException e) {
            resultText.setText("Por favor ingrese valores válidos.");
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
