package it.unicam.cs.mpgc.jtime118724.Infrastructure;

import it.unicam.cs.mpgc.jtime118724.Dao.Abstract.IAttivitaDao;
import it.unicam.cs.mpgc.jtime118724.Dao.Abstract.IProgettoDao;

public record AppContext(IAttivitaDao attivitaDao, IProgettoDao progettoDao){ }
