package org.smartregister.fragment;

import android.app.Activity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.MockedStatic;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import java.lang.reflect.Method;
import org.smartregister.chw.malaria.activity.BaseMalariaProfileActivity;
import org.smartregister.chw.malaria.fragment.BaseMalariaRegisterFragment;
import org.smartregister.commonregistry.CommonPersonObjectClient;

import static org.mockito.Mockito.times;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 28)
public class BaseMalariaRegisterFragmentTest {
    @Mock public CommonPersonObjectClient client;

    private BaseMalariaRegisterFragment baseMalariaRegisterFragment;
    private androidx.fragment.app.FragmentActivity hostActivity;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        baseMalariaRegisterFragment = Mockito.spy(new BaseMalariaRegisterFragment());
        hostActivity = Mockito.mock(androidx.fragment.app.FragmentActivity.class);
        // Stub getActivity() to avoid null and use our mock Activity
        Mockito.doReturn(hostActivity).when(baseMalariaRegisterFragment).getActivity();
    }

    @Test
    public void openProfile() throws Exception {
        Method m = BaseMalariaRegisterFragment.class.getDeclaredMethod("openProfile", String.class);
        m.setAccessible(true);
        try (MockedStatic<BaseMalariaProfileActivity> ms = Mockito.mockStatic(BaseMalariaProfileActivity.class)) {
            m.invoke(baseMalariaRegisterFragment, (String) null);
            ms.verify(() -> BaseMalariaProfileActivity.startProfileActivity(hostActivity, null), times(1));
        }
    }
}
