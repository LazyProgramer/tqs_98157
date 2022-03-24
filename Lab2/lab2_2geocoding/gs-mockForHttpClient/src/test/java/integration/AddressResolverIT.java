package integration;

import connection.TqsBasicHttpClient;
import geocoding.Address;
import geocoding.AddressResolver;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddressResolverIT {

    private AddressResolver resolver;

    @BeforeEach
    public void init(){
        TqsBasicHttpClient httpClient = new TqsBasicHttpClient();
        resolver= new AddressResolver(httpClient);
    }

    @Test
    public void whenGoodCoordidates_returnAddress() throws IOException, URISyntaxException, ParseException {

        //todo
        Optional<Address> result = resolver.findAddressForLocation(40.640661, -8.656688);

        assertEquals( result, Optional.of(new Address( "Cais do Alboi", "Glória e Vera Cruz", "Centro", "3800-246", null) ));
        // repeat the same tests conditions from AddressResolverTest, without mocks

    }

    @Test
    public void whenBadCoordidates_thenReturnNoValidAddrress() throws IOException, URISyntaxException, ParseException {

        //todo
        Optional<Address> result = resolver.findAddressForLocation(-300, -810);

        assertEquals( result, Optional.empty());
        // repeat the same tests conditions from AddressResolverTest, without mocks
        
    }

}
