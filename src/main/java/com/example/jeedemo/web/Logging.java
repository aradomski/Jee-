package com.example.jeedemo.web;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "logging")
@ApplicationScoped
public class Logging {

	private static Logger logger = Logger.getLogger(Logger.class.getName());
	private static FileHandler fh = null;

	public Logging() {
		try {
			boolean append = true;
			fh = new FileHandler("./bla/my.log", append);
		} catch (IOException ignore) {
		}
		logger.addHandler(fh);
		logger.setLevel(Level.ALL);
	}

	public Logger getLogger() {
		return logger;
	}
}