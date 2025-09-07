package org.smartregister.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.smartregister.chw.malaria.domain.MemberObject;
import org.smartregister.chw.malaria.fragment.BaseMalariaCallDialogFragment;

public class BaseMalariaCallDialogFragmentTest {
    @Spy
    public BaseMalariaCallDialogFragment baseMalariaCallDialogFragment;

    @Mock
    public ViewGroup viewGroup;

    @Mock
    public View view;

    @Mock
    public MemberObject memberObject;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        Field f = BaseMalariaCallDialogFragment.class.getDeclaredField("MEMBER_OBJECT");
        f.setAccessible(true);
        f.set(null, memberObject);
    }

    @Test(expected = Exception.class)
    public void setCallTitleFamilyHead() throws Exception {
        TextView textView = Mockito.mock(TextView.class);

        Mockito.when(memberObject.getBaseEntityId()).thenReturn("123456");
        Mockito.when(memberObject.getFamilyHead()).thenReturn("123456");

        Mockito.when(viewGroup.findViewById(view.getId())).thenReturn(textView);

        Method m = BaseMalariaCallDialogFragment.class.getDeclaredMethod("setCallTitle", android.view.ViewGroup.class, int.class, String.class);
        m.setAccessible(true);
        m.invoke(baseMalariaCallDialogFragment, viewGroup, view.getId(), "message");
        Assert.assertEquals("message Head of family", textView.getText());
    }

    @Test(expected = Exception.class)
    public void setCallTitleAnc() throws Exception {
        TextView textView = Mockito.mock(TextView.class);

        Mockito.when(memberObject.getAncMember()).thenReturn("0");

        Mockito.when(viewGroup.findViewById(view.getId())).thenReturn(textView);

        Method m = BaseMalariaCallDialogFragment.class.getDeclaredMethod("setCallTitle", android.view.ViewGroup.class, int.class, String.class);
        m.setAccessible(true);
        m.invoke(baseMalariaCallDialogFragment, viewGroup, view.getId(), "message");
        Assert.assertEquals("message ANC Client", textView.getText());
    }

    @Test(expected = Exception.class)
    public void setCallTitleCareGiver() throws Exception {
        TextView textView = Mockito.mock(TextView.class);

        Mockito.when(memberObject.getBaseEntityId()).thenReturn("123456");
        Mockito.when(memberObject.getPrimaryCareGiver()).thenReturn("123456");

        Mockito.when(viewGroup.findViewById(view.getId())).thenReturn(textView);

        Method m = BaseMalariaCallDialogFragment.class.getDeclaredMethod("setCallTitle", android.view.ViewGroup.class, int.class, String.class);
        m.setAccessible(true);
        m.invoke(baseMalariaCallDialogFragment, viewGroup, view.getId(), "message");
        Assert.assertEquals("message Primary Caregiver", textView.getText());
    }

    @Test(expected = Exception.class)
    public void setCallTitlePnc() throws Exception {
        TextView textView = Mockito.mock(TextView.class);

        Mockito.when(memberObject.getPncMember()).thenReturn("0");

        Mockito.when(viewGroup.findViewById(view.getId())).thenReturn(textView);

        Method m = BaseMalariaCallDialogFragment.class.getDeclaredMethod("setCallTitle", android.view.ViewGroup.class, int.class, String.class);
        m.setAccessible(true);
        m.invoke(baseMalariaCallDialogFragment, viewGroup, view.getId(), "message");
        Assert.assertEquals("message PNC Client", textView.getText());
    }

    @Test(expected = Exception.class)
    public void setCallTitle() throws Exception {
        TextView textView = Mockito.mock(TextView.class);

        Mockito.when(memberObject.getBaseEntityId()).thenReturn("1");
        Mockito.when(memberObject.getFamilyHead()).thenReturn("123456");

        Mockito.when(viewGroup.findViewById(view.getId())).thenReturn(textView);

        Method m = BaseMalariaCallDialogFragment.class.getDeclaredMethod("setCallTitle", android.view.ViewGroup.class, int.class, String.class);
        m.setAccessible(true);
        m.invoke(baseMalariaCallDialogFragment, viewGroup, view.getId(), "message");
        Assert.assertEquals("message Malaria Client", textView.getText());
    }

    @Test(expected = Exception.class)
    public void initUI() throws Exception {
        Mockito.when(memberObject.getPhoneNumber()).thenReturn("123456789");
        Method m = BaseMalariaCallDialogFragment.class.getDeclaredMethod("initUI", android.view.ViewGroup.class);
        m.setAccessible(true);
        m.invoke(baseMalariaCallDialogFragment, viewGroup);

    }
}
