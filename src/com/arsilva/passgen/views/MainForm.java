package com.arsilva.passgen.views;

import com.arsilva.passgen.presenters.GeneratorPresenter;
import com.arsilva.passgen.presenters.IGeneratorPresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm implements IGeneratorView {
    private JTextField txtFieldPwd;
    private JCheckBox chkBoxUpper;
    private JCheckBox chkBoxLower;
    private JCheckBox chkBoxNumbers;
    private JCheckBox chkBoxSymbols;
    private JButton BtnGenerate;
    private JSpinner spnrSize;
    private JPanel rootPanel;

    private IGeneratorPresenter presenter;

    public MainForm() {
        presenter = new GeneratorPresenter();
        presenter.attachView(this);
        BtnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.generatePassword(
                        Integer.parseInt(spnrSize.getValue().toString()),
                        chkBoxUpper.isSelected(),
                        chkBoxLower.isSelected(),
                        chkBoxNumbers.isSelected(),
                        chkBoxSymbols.isSelected()
                );
            }
        });
    }

    @Override
    public void showGeneratedPassword(String password) {
        txtFieldPwd.setText(password);
    }

    @Override
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
