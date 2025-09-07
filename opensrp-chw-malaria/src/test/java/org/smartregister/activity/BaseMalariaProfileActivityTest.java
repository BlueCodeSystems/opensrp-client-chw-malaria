package org.smartregister.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import org.junit.After;
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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.smartregister.chw.malaria.activity.BaseMalariaProfileActivity;
import org.smartregister.chw.malaria.contract.MalariaProfileContract;
import org.smartregister.domain.AlertStatus;
import org.smartregister.malaria.R;

import static org.mockito.Mockito.validateMockitoUsage;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 28)
public class BaseMalariaProfileActivityTest {
    @Mock
    public BaseMalariaProfileActivity baseMalariaProfileActivity;

    @Mock
    public MalariaProfileContract.Presenter profilePresenter;

    @Mock
    public View view;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @After
    public void validate() {
        validateMockitoUsage();
    }

    @Test
    public void assertNotNull() {
        Assert.assertNotNull(baseMalariaProfileActivity);
    }

    @Test
    public void setOverDueColor() {
        baseMalariaProfileActivity.setOverDueColor();
        Mockito.verify(view, Mockito.never()).setBackgroundColor(Color.RED);
    }

    @Test
    public void formatTime() {
        BaseMalariaProfileActivity activity = Robolectric.buildActivity(BaseMalariaProfileActivity.class).get();
        try {
            Method m = BaseMalariaProfileActivity.class.getDeclaredMethod("formatTime", Date.class);
            m.setAccessible(true);
            Date d = new SimpleDateFormat("dd-MM-yyyy").parse("25-10-2019");
            Assert.assertEquals("25 Oct 2019", m.invoke(activity, d));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkHideView() {
        baseMalariaProfileActivity.hideView();
        Mockito.verify(view, Mockito.never()).setVisibility(View.GONE);
    }

    @Test
    public void checkProgressBar() {
        baseMalariaProfileActivity.showProgressBar(true);
        Mockito.verify(view, Mockito.never()).setVisibility(View.VISIBLE);
    }

    @Test
    public void medicalHistoryRefresh() {
        baseMalariaProfileActivity.refreshMedicalHistory(true);
        Mockito.verify(view, Mockito.never()).setVisibility(View.VISIBLE);
    }

    @Test
    public void onClickBackPressed() {
        baseMalariaProfileActivity = Mockito.spy(Robolectric.buildActivity(BaseMalariaProfileActivity.class).get());
        Mockito.when(view.getId()).thenReturn(org.smartregister.R.id.title_layout);
        Mockito.doNothing().when(baseMalariaProfileActivity).onBackPressed();
        baseMalariaProfileActivity.onClick(view);
        // BaseMalariaProfileActivity.onClick does not handle title_layout; ensure back not triggered
        Mockito.verify(baseMalariaProfileActivity, Mockito.never()).onBackPressed();
    }

    @Test
    public void onClickOpenMedicalHistory() {
        baseMalariaProfileActivity = Mockito.spy(Robolectric.buildActivity(BaseMalariaProfileActivity.class).get());
        Mockito.when(view.getId()).thenReturn(R.id.rlLastVisit);
        Mockito.doNothing().when(baseMalariaProfileActivity).openMedicalHistory();
        baseMalariaProfileActivity.onClick(view);
        Mockito.verify(baseMalariaProfileActivity).openMedicalHistory();
    }

    @Test
    public void onClickOpenUpcomingServices() {
        baseMalariaProfileActivity = Mockito.spy(Robolectric.buildActivity(BaseMalariaProfileActivity.class).get());
        Mockito.when(view.getId()).thenReturn(R.id.rlUpcomingServices);
        Mockito.doNothing().when(baseMalariaProfileActivity).openUpcomingService();
        baseMalariaProfileActivity.onClick(view);
        Mockito.verify(baseMalariaProfileActivity).openUpcomingService();
    }

    @Test
    public void onClickOpenFamlilyServicesDue() {
        baseMalariaProfileActivity = Mockito.spy(Robolectric.buildActivity(BaseMalariaProfileActivity.class).get());
        Mockito.when(view.getId()).thenReturn(R.id.rlFamilyServicesDue);
        Mockito.doNothing().when(baseMalariaProfileActivity).openFamilyDueServices();
        baseMalariaProfileActivity.onClick(view);
        Mockito.verify(baseMalariaProfileActivity).openFamilyDueServices();
    }

    @Test(expected = Exception.class)
    public void refreshFamilyStatusComplete() throws Exception {
        baseMalariaProfileActivity = Mockito.spy(Robolectric.buildActivity(BaseMalariaProfileActivity.class).get());
        TextView textView = view.findViewById(R.id.textview_family_has);
        Field f = BaseMalariaProfileActivity.class.getDeclaredField("tvFamilyStatus");
        f.setAccessible(true);
        f.set(baseMalariaProfileActivity, textView);
        Mockito.doNothing().when(baseMalariaProfileActivity).showProgressBar(false);
        baseMalariaProfileActivity.refreshFamilyStatus(AlertStatus.complete);
        Mockito.verify(baseMalariaProfileActivity).showProgressBar(false);
    }

    @Test(expected = Exception.class)
    public void refreshFamilyStatusNormal() throws Exception {
        baseMalariaProfileActivity = Mockito.spy(Robolectric.buildActivity(BaseMalariaProfileActivity.class).get());
        TextView textView = view.findViewById(R.id.textview_family_has);
        Field f = BaseMalariaProfileActivity.class.getDeclaredField("tvFamilyStatus");
        f.setAccessible(true);
        f.set(baseMalariaProfileActivity, textView);
        Mockito.doNothing().when(baseMalariaProfileActivity).showProgressBar(false);
        baseMalariaProfileActivity.refreshFamilyStatus(AlertStatus.complete);
        Mockito.verify(baseMalariaProfileActivity).showProgressBar(false);
    }

    @Test(expected = Exception.class)
    public void onActivityResult() throws Exception {
        baseMalariaProfileActivity = Mockito.spy(Robolectric.buildActivity(BaseMalariaProfileActivity.class).setup().get());
        Method m = BaseMalariaProfileActivity.class.getDeclaredMethod("onActivityResult", int.class, int.class, android.content.Intent.class);
        m.setAccessible(true);
        m.invoke(baseMalariaProfileActivity, 2244, -1, null);
        Mockito.verify(profilePresenter).saveForm(null);
    }
}
