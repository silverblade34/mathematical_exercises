package alvarez.pa1.org.ui.convertbase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConvertBaseViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public ConvertBaseViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ConvertBase fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
