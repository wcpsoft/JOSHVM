/*
 * Copyright (C) Max Mu
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License version 2 for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 * Please visit www.joshvm.org if you need additional information or
 * have any questions.
 */
package org.joshvm.media;

/**
 * Listener to receive VAD begin and end notifications.
 */
public interface VADCommandControllerListener {

	public final static int COMMAND_INVALID = -1;
	public final static int COMMAND_SYSTEM = 0;
	public final static int COMMAND_USER_DEFINED = 10000;
	
	/**
	 * Called when native VAD engine has detected pre-defined command
	 * 
	 * @param command A pre-defined voice command ID which has been detected
	 * @param recorder The AudioRecorder object to get the raw audio data
	 */
	public void onVADCommand(int command, AudioRecorder recorder);

	/**
	 * Returns the pre-defined command ID which has been detected
	 *
	 */
	public int getVADCommand();
}

