package com.easyticket.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class SimpleThreadLocalPool {
	private static final Logger logger = Logger.getLogger(SimpleThreadLocalPool.class);
	
	private static ThreadPoolExecutor threadPoolExecutor = null;

	private SimpleThreadLocalPool() {
	}

	public static void init() {
		threadPoolExecutor = new ThreadPoolExecutor(5, 200, 200L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.CallerRunsPolicy());
		logger.info("线程池初始化完成！");
	}

	public static synchronized ThreadPoolExecutor get() {
		return threadPoolExecutor;
	}

}
