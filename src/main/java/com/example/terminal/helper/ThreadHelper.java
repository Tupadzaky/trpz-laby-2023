package com.example.terminal.helper;

import javafx.application.Platform;

import java.util.concurrent.*;

public class ThreadHelper {

    private static final Semaphore uiSemaphore = new Semaphore(1);
    private static final ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();

    public static void runActionLater(final Runnable runnable) {

        if (Platform.isFxApplicationThread()) {
            runnable.run();
        } else {
            try {
                uiSemaphore.acquire();
                Platform.runLater(() -> {
                    try {
                        runnable.run();
                        releaseUiSemaphor();
                    } catch (Exception e) {
                        releaseUiSemaphor();
                        throw new RuntimeException(e);
                    }
                });
            } catch (Exception e) {
                releaseUiSemaphor();
                throw new RuntimeException(e);
            }
        }

    }

    private static void releaseUiSemaphor() {
        singleExecutorService.submit(() -> {
            uiSemaphore.release();
        });
    }

    public static void runActionLater(Runnable runnable, boolean force) {
        if (force) {
            Platform.runLater(runnable);
        } else {
            runActionLater(runnable);
        }
    }

    public static void start(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void awaitLatch(CountDownLatch countDownLatch) {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void stopExecutorService() {
        if (!singleExecutorService.isShutdown()) {
            singleExecutorService.shutdown();
        }
    }

}
