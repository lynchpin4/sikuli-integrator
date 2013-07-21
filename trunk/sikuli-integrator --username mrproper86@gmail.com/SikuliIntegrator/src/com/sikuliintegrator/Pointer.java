package com.sikuliintegrator;

import org.sikuli.script.Settings;

import com.sikuliintegrator.arguments.ArgumentsMapping;
import com.sikuliintegrator.exceptions.ExceptionHandler;
import com.sikuliintegrator.exceptions.UnknownCommandException;
import com.sikuliintegrator.exceptions.WrongArgumentCountException;

public class Pointer {
	public static void main(String[] args) {

//		args = new String[4];
//		args[0] = "C:\\pattern.png";
//		args[1] = "EXISTS";
//		args[2] = "0.9";
//		args[3] = "5000";

		try {

			if (args.length == Constants.ARGUMENTS_COUNT) {
				ArgumentsMapping arguments = new ArgumentsMapping(args);

				disableCommandLineLogs();

				org.sikuli.script.Settings.MinSimilarity = arguments
						.getSimilarity();

				if (arguments.getCommand() == null) {
					throw new UnknownCommandException();
				} else {

					switch (arguments.getCommand()) {
					case EXISTS: {

						Operation.GetPoint(arguments);
					}
						break;

					case CLICK: {

						Operation.Click(arguments);
					}
						break;

					case DOUBLE_CLICK: {
						Operation.DoubleClick(arguments);
					}
						break;

					case RIGHT_CLICK: {
						Operation.RightClick(arguments);
					}
						break;
						
					case HOVER: {
						Operation.Hover(arguments);
					}
						break;
						
					//EiderMauricio@gmail.com source code added
					case FIND_ALL: {
						Operation.FindAll(arguments);
					}
						break;
					
					case WAIT_VANISH: {
						Operation.WaitVanish(arguments);
					}
						break;	
						
						
					default: {
						throw new UnknownCommandException();
					}
					}

				}
			} else {
				throw new WrongArgumentCountException();
			}

		} catch (Exception ex) {
			ExceptionHandler.handle(ex);
		}
		System.exit(Result.getStatus());
	}

	private static void disableCommandLineLogs() {
		Settings.InfoLogs = false;
		Settings.DebugLogs = false;
		Settings.ProfileLogs = false;
		Settings.ActionLogs = false;
	}
}
