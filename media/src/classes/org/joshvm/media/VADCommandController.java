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

/**
 * VADCommandController provides access to vad command control.
 */
public class VADCommandController {
	private static final VADCommandController INSTANCE;
	private AudioRecorder recorder;

	static {
		INSTANCE = new VADCommandController();
	}

	private VADCommandController() {
	}

	/**
	 * Returns VADCommandController instance
	 */
	public static VADCommandController getInstance() {
		return INSTANCE;
	}

	/**
	 * Register a callback to be invoked when native vad engine detected
	 * command.
	 * 
	 * @param listener the callback that will be run.
	 */
	public void setVADCommandControllerListener(final VADCommandControllerListener listener) {
		EventListenerProxy.setVADControllerListener(
				listener == null ? null : new EventListenerProxy.VADControllerListenerExtAdaptor() {
					public void onVADCommand(int command, AudioRecorder recorder) {
						listener.onVADCommand(command, recorder);
					}

					public AudioRecorder getAudioRecorder() {
						return recorder;
					}
				});
	}

	/**
	 * Starts VAD Command Controller which will automatically stop after invoke
	 * callback.
	 * 
	 * @see #setVADCommandControllerListener
	 * @throws IOException
	 */
	public void start() throws IOException {
		if (recorder == null) {
			try {
				recorder = new VADAudioRecorder();
			} catch (Exception e) {
				throw new IOException("Failed to start VADCommandController.");
			}
		}
		start0();
	}

	/**
	 * Releases the native resources.
	 * 
	 * @throws IOException if an I/O error occurs
	 */
	public void release() throws IOException {
		if (recorder != null) {
			recorder.release();
			recorder = null;
		}
	}

	private native void start0();
}
