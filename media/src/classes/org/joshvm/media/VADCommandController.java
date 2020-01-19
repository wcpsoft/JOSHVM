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

import java.io.IOException;

import com.joshvm.media.EventListenerProxy;
import com.joshvm.media.VADAudioRecorder;
import org.joshvm.util.ByteBuffer;
import com.joshvm.media.VADControllerMode;

/**
 * VADController provides access to vad control.
 */
public class VADCommandController {
	private static final VADCommandController INSTANCE;
	private static final VADController privVADController;
	private AudioRecorder recorder;
	
	static {
		INSTANCE = new VADCommandController();
		privVADController = VADController.getInstance();
	}

	private VADCommandController() {
	}

	/**
	 * Returns VADController instance
	 */
	public static VADCommandController getInstance() {
		return INSTANCE;
	}

	/**
	 * Set vad off time
	 * 
	 * @param timeout vad off time in milliseconds
	 */
	public void setTimeout(int timeout) {
		privVADController.setTimeout(timeout);
	}

	/**
	 * Register a callback to be invoked when native vad engine is in begin or
	 * end state.
	 * 
	 * @param listener the callback that will be run.
	 */
	public void setVADCommandControllerListener(final VADCommandControllerListener listener) {
		privVADController.setVADControllerListener(new VADControllerListener() {
					public void onVADBegin(AudioRecorder audioRecorder) {
						recorder = audioRecorder;
					}

					public void onVADEnd() {
						listener.onVADCommand(listener.getVADCommand(), recorder);
					}
				});
	}

	/**
	 * Starts VAD Command Controller.
	 * 
	 * @throws IOException
	 */
	public void start() throws IOException {
		VADControllerMode.setMode(VADControllerMode.COMMAND);
		privVADController.start();
	}

	/**
	 * Pauses VAD Command Controller.
	 * 
	 * @throws IOException
	 */
	public void pause() throws IOException {
		privVADController.pause();
	}

	/**
	 * Resumes VAD Command Controller.
	 * 
	 * @throws IOException
	 */
	public void resume() throws IOException {
		privVADController.resume();
	}

	/**
	 * Stops VAD Command Controller.
	 * 
	 * @throws IOException
	 */
	public void stop() throws IOException {
		privVADController.stop();
	}
}

