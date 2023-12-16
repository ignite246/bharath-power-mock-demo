package com.rahul.learning.powermock.java2blog;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({MultipleTypesOfMethodService.class})
public class MultipleTypesOfMethodServiceTest {

    @Test
    public void testStaticMethod() {
        String expectation = "Hello Baba";

        PowerMockito.mockStatic(MultipleTypesOfMethodService.class);   //Mocking Static
        PowerMockito.when(MultipleTypesOfMethodService.staticMethod()).thenReturn(expectation);

        String actual = MultipleTypesOfMethodService.staticMethod();
        Assert.assertEquals(expectation, actual);

    }

    @Test
    public void testFinalMethod() throws Exception {

        String expResponse = "Hello PowerMockito";

        MultipleTypesOfMethodService mockObject = PowerMockito.mock(MultipleTypesOfMethodService.class);
        PowerMockito.whenNew(MultipleTypesOfMethodService.class).withNoArguments().thenReturn(mockObject);

        MultipleTypesOfMethodService service = new MultipleTypesOfMethodService();
        PowerMockito.verifyNew(MultipleTypesOfMethodService.class).withNoArguments();

        PowerMockito.when(service.finalMethod()).thenReturn(expResponse);
        String actualResponse = service.finalMethod();

        Mockito.verify(service).finalMethod();
        Assert.assertEquals(expResponse, actualResponse);
    }
}
