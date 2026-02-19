package it.unicam.cs.mpgc.jtime118724.Controller.Abstract;

import it.unicam.cs.mpgc.jtime118724.Infrastructure.AppContext;
import it.unicam.cs.mpgc.jtime118724.Navigator.INavigator;

public interface IController {
    void init(AppContext ctx, INavigator nav);
}
