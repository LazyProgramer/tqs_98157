package lab2_1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Unit test for simple App.
 */
@ExtendWith(MockitoExtension.class)
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @Mock
    IStockmarketService iStocksMarket;
    @InjectMocks
    StocksPortfolio portfolio;

    @Test
    public void getCorrectTotalVal()
    {
        /* Old way ↓↓↓ */
        // IStockmarketService iStocksMarket = Mockito.mock(IStockmarketService.class);

        // StocksPortfolio portfolio = new StocksPortfolio(iStocksMarket);

        when(iStocksMarket.lookUpPrice("MSFT")).thenReturn(4.0);
        when(iStocksMarket.lookUpPrice("EBAY")).thenReturn(1.5);

        portfolio.addStock(new Stock("MSFT",2));
        portfolio.addStock(new Stock("EBAY",4));
        Double result = portfolio.getTotalValue();
        
        assertEquals(14.0, result);
        verify(iStocksMarket,times(2)).lookUpPrice(anyString());
    }

    @Test
    public void getCorrectTotalVal2()
    {
        /* Old way ↓↓↓ */
        //IStockmarketService iStocksMarket = Mockito.mock(IStockmarketService.class);

        //StocksPortfolio portfolio = new StocksPortfolio(iStocksMarket);

        when(iStocksMarket.lookUpPrice("MSFT")).thenReturn(4.0);
        when(iStocksMarket.lookUpPrice("EBAY")).thenReturn(1.5);
        when(iStocksMarket.lookUpPrice("AAPL")).thenReturn(2.0);

        portfolio.addStock(new Stock("MSFT",2));
        portfolio.addStock(new Stock("AAPL",4));
        portfolio.addStock(new Stock("EBAY",1));
        Double result = portfolio.getTotalValue();

        assertEquals(17.5, result);
        verify(iStocksMarket,times(3)).lookUpPrice(anyString());
        verify(iStocksMarket).lookUpPrice("MSFT");
        verify(iStocksMarket).lookUpPrice("AAPL");
        verify(iStocksMarket).lookUpPrice("EBAY");
    }
}
