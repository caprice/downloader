/*
 * Copyright 2013 Christian Robert
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.perdian.downloader.ui.fx.panels;

import de.perdian.apps.downloader.core.DownloadEngine;
import de.perdian.apps.downloader.core.DownloadJob;
import de.perdian.apps.downloader.core.DownloadListener;

public class ActiveDownloadsPane extends AbstractItemContainerPane<ActiveDownloadItemPane> {

    public ActiveDownloadsPane(DownloadEngine engine) {
        engine.addListener(new DownloadListenerImpl());
    }

    @Override
    protected ActiveDownloadItemPane createItemPane(DownloadJob job) {
        ActiveDownloadItemPane itemPane = new ActiveDownloadItemPane(job);
        return itemPane;
    }

    // -------------------------------------------------------------------------
    // --- Inner classes -------------------------------------------------------
    // -------------------------------------------------------------------------

    class DownloadListenerImpl implements DownloadListener {

        @Override
        public void onJobStarted(DownloadJob job) {
            ActiveDownloadsPane.this.addDownloadJob(job);
        }

        @Override
        public void onJobCompleted(DownloadJob job) {
            ActiveDownloadsPane.this.removeDownloadJob(job);
        }

    }

}