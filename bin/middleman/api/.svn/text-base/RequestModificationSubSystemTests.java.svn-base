package middleman.api;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.anyString;
import static org.mockito.MockitoAnnotations.initMocks;
import middleman.proxy.HTTPRequest;
import middleman.proxy.ProxyServer;
import middleman.proxy.RequestFilter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

public class RequestModificationSubSystemTests {

    @Mock ProxyServer proxy;
    @Mock HTTPRequest request;    
    MiddlemanController middlemanApi = new MiddlemanController();
    
    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void whenApiIsUsedToAddAHeaderThenTheProxyRequestFilterShouldModifyRequestsAppropriately() {
        middlemanApi.control(proxy);
        
        middlemanApi.addRequestModifier().addingHeader("HeaderAbc", "xyz");
        filterAddedToProxy().filterRequest(request);
        
        verify(request).addHeader("HeaderAbc", "xyz");
    }

    @Test
    public void whenApiIsNotUsedToAddAHeaderThenTheProxyRequestFilterShouldNotModifyRequests() {
        middlemanApi.control(proxy);
        
        filterAddedToProxy().filterRequest(request);
        
        verify(request, never()).addHeader(anyString(), anyString());
    }

    @Test
    public void givenApiHasBeenUsedToAddAHeaderWhenModificationsAreClearedThenTheProxyRequestFilterShouldNotModifyRequests() {
        middlemanApi.control(proxy);
        middlemanApi.addRequestModifier().addingHeader("HeaderAbc", "xyz");

        middlemanApi.clearRequestModifiers();
        filterAddedToProxy().filterRequest(request);
        
        verify(request, never()).addHeader(anyString(), anyString());
    }

    private RequestFilter filterAddedToProxy() {
        ArgumentCaptor<RequestFilter> addedFilterCaptor = ArgumentCaptor.forClass(RequestFilter.class);
        verify(proxy).setProxyRequestFilter(addedFilterCaptor.capture());
        return addedFilterCaptor.getValue();
    }
}
