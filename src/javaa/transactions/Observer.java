package javaa.transactions;

import javaa.transactions.Transaction;

public interface Observer {
    void update(Transaction transaction);
}

//Observer Pattern pentru istoricul tranzacțiilor
//Motivație: deoarece observer permite ca istoricul tranzacțiilor să fie automat actualizat de fiecare dată când are loc o tranzacție,
// menținând un stat consistent. La fel, fiind un sistem de tranzacționare, e importanta urmarirea tuturor tranzacțiilor efectuate pentru audit,
// raportare și analiză. Folosinf această metodă, componentele responsabile cu istoricul tranzacțiilor sunt notificate și
// actualizate imediat ce o tranzacție se întâmplă, asigurând că toate înregistrările sunt sincronizate cu activitatea de tranzacționare.