package lab2_1;

import java.util.ArrayList;

public class StocksPortfolio {
    private ArrayList<Stock> stocks;
    private IStockmarketService stockmarket;

    StocksPortfolio(IStockmarketService stockmarket){
        this.stockmarket = stockmarket;
        this.stocks = new ArrayList<Stock>();
    }

    public void addStock(Stock stock){
        stocks.add(stock);
    }
    public double getTotalValue(){
        Double totalVal = 0.0;
        for(Stock s:stocks){
            totalVal = totalVal + (s.getQuantity()*stockmarket.lookUpPrice(s.getLabel()));
        }
        return totalVal;
    }
}
