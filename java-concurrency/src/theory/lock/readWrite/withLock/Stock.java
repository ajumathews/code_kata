package theory.lock.readWrite.withLock;

public class Stock {

    private int stockPrice;
    private boolean tradingOpen;

    public Stock() {
        stockPrice = 100;
        tradingOpen = true;
    }

    public void updateStockPrice(int change) {
        stockPrice += change;
    }

    public int getStockPrice() {
        return stockPrice;
    }

    public boolean isTradingOpen() {
        return tradingOpen;
    }

    public void setTradingOpen(boolean tradingOpen) {
        this.tradingOpen = tradingOpen;
    }
}
