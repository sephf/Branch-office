package gestion.presentation.main;
import gestion.Application;
import gestion.logic.Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Controller {
    Model model;
    View view;
    public Controller(View view, Model model)
    {
        this.model=model;
        this.view=view;
        view.setModel(model);
        view.setController(this);
    }
    public void actionPerformed(ActionEvent e){model.commit();}
    public void show(){
        Application.window.setContentPane(view.getPanel());
        Application.window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Service.instance().store();
            }
        });
    }
}
