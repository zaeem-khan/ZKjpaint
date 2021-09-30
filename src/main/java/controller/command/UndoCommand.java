package controller.command;

import controller.interfaces.ICommand;

public class UndoCommand implements ICommand {
  @Override
  public void run() {
    CommandHistory.undo();
  }
}
