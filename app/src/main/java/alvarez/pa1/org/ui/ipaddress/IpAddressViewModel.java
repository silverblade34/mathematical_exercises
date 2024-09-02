package alvarez.pa1.org.ui.ipaddress;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IpAddressViewModel  extends ViewModel {
    private final MutableLiveData<String> mText;

    public IpAddressViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento IP Address");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
