package ca.bytetube.ood._14_alexa;

public interface Command {
    boolean validate();
    void execute();
}
