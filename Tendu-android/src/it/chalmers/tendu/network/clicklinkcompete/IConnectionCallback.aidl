/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * AIDL for the Bluetooth Connect, Link, Compete Service
 * IConnectionCallback.java is autogenerated from this
 */

package it.chalmers.tendu.network.clicklinkcompete;

// Declare the interface.
oneway interface IConnectionCallback {
  void incomingConnection(String device);
  void maxConnectionsReached();
  void messageReceived(String device, String message);
  void connectionLost(String device);
}
