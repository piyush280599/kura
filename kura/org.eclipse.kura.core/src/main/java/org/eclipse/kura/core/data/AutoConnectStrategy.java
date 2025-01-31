/*******************************************************************************
 * Copyright (c) 2022 Eurotech and/or its affiliates and others
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *  Eurotech
 ******************************************************************************/
package org.eclipse.kura.core.data;

import org.eclipse.kura.data.listener.DataServiceListener;

interface AutoConnectStrategy extends DataServiceListener {

    public void shutdown();

    public void onPublishRequested(String topic, byte[] payload, int qos, boolean retain, int priority);

    interface ConnectionManager {

        void startConnectionTask();

        void stopConnectionTask();

        void disconnect();

        DataMessage getNextMessage();

        boolean hasInFlightMessages();

        boolean isConnected();

    }
}
