package alvarez.pa1.org.ui.simplebankruptcies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SimpleBankruptciesViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public SimpleBankruptciesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento Sumar quebrados");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
