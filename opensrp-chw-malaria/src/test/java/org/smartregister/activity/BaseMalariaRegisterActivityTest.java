package org.smartregister.activity;

import android.content.Intent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import java.lang.reflect.Method;
import org.smartregister.chw.malaria.activity.BaseMalariaRegisterActivity;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 28)
public class BaseMalariaRegisterActivityTest {

    @Mock public Intent data;

    private BaseMalariaRegisterActivity baseMalariaRegisterActivity;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Build the Activity instance without triggering onCreate to avoid CoreLibrary init
        baseMalariaRegisterActivity = Robolectric.buildActivity(BaseMalariaRegisterActivity.class).get();
    }

    @Test
    public void assertNotNull() {
        Assert.assertNotNull(baseMalariaRegisterActivity);
    }

    @Test
    public void testFormConfig() {
        Assert.assertNull(baseMalariaRegisterActivity.getFormConfig());
    }

    @Test
    public void checkIdentifier() {
        Assert.assertNotNull(baseMalariaRegisterActivity.getViewIdentifiers());
    }

    @Test(expected = Exception.class)
    public void onActivityResult() throws Exception {
        Method m = BaseMalariaRegisterActivity.class.getDeclaredMethod("onActivityResult", int.class, int.class, android.content.Intent.class);
        m.setAccessible(true);
        m.invoke(baseMalariaRegisterActivity, 2244, -1, data);
        Mockito.verify(baseMalariaRegisterActivity.presenter()).saveForm(null);
    }
}
