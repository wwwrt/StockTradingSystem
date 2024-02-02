package javaa.strategies;

import javaa.stock.Stock;

public interface TradingStrategy {
    void execute(Stock stock, int quantity);
}


//Strategy Pattern pentru acțiunile utilizatorilor și pt strategii de tranzacționare
//Motivație: deoarece Strategy îmi oferă flexibilitate în extinderea acțiunilor utilizatorilor și a strategiilor de tranzacționare,
//fără a modifica codul existent. Asta practic îi permite sistemului să fie adaptabil și să suporte ușor diferite comportamente
// sau algoritmi de tranzacționare, care pot fi schimbați dinamic la runtime. De exemplu, diferiți utilizatori pot folosi diverse
// strategii de investiții, iar prin aplicarea pattern-ului Strategy, pot gestiona această varietate într-un mod ordonat și eficient.