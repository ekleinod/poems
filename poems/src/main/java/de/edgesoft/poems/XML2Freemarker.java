package de.edgesoft.poems;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Collator;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.edgesoft.edgeutils.EdgeUtilsException;
import de.edgesoft.edgeutils.commandline.AbstractMainClass;
import de.edgesoft.edgeutils.files.JAXBFiles;
import de.edgesoft.poems.jaxb.Poem;
import de.edgesoft.poems.jaxb.Poems;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * Converts XML to file using freemarker template.
 *
 * ## Legal stuff
 *
 * Copyright 2016-2016 Ekkart Kleinod <ekleinod@edgesoft.de>
 *
 * This file is part of poema.
 *
 * poema is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * poema is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with poema. If not, see <http://www.gnu.org/licenses/>.
 *
 * @author Ekkart Kleinod
 * @version 0.1.0
 * @since 0.1.0
 */
public class XML2Freemarker extends AbstractMainClass {

	/**
	 * Logger.
	 *
	 * @version 0.1.0
	 * @since 0.1.0
	 */
	public static final Logger logger = LogManager.getLogger(XML2Freemarker.class.getPackage().getName());

	/**
	 * Command line entry point.
	 *
	 * @param args command line arguments
	 *
	 * @version 0.1.0
	 * @since 0.1.0
	 */
	public static void main(String[] args) {
		new XML2Freemarker().executeOperation(args);
	}

	/**
	 * Programmatic entry point, initializing and executing main functionality.
	 *
	 * - set description setDescription("...");
	 * - add options addOption("short", "long", "description", argument?, required?);
	 * - call init(args);
	 * - call operation execution with arguments
	 *
	 * @version 0.1.0
	 * @since 0.1.0
	 */
	@Override
	public void executeOperation(final String[] args) {

		setDescription("XML to text using freemarker template.");

		addOption("x", "xml", "xml file", true, true);
		addOption("t", "template", "template file.", true, true);
		addOption("o", "output", "output file.", true, true);

		init(args);

		conversionOperation(getOptionValue("x"), getOptionValue("t"), getOptionValue("o"));

	}

	/**
	 * Executes conversion operation.
	 *
	 * @param theInputFile input filename
	 * @param theTemplateFile template filename
	 * @param theOutputFile output filename
	 *
	 * @version 0.1.0
	 * @since 0.1.0
	 */
	public void conversionOperation(final String theInputFile, final String theTemplateFile, final String theOutputFile) {

		logger.info("start.");

		Objects.requireNonNull(theInputFile, "input filename must not be null");
		Objects.requireNonNull(theTemplateFile, "template filename must not be null");
		Objects.requireNonNull(theOutputFile, "output filename must not be null");

		try {

			logger.info("reading xml file.");

			Poems dtaPoems = JAXBFiles.unmarshal(theInputFile, Poems.class);


			logger.info("sorting poems by date.");

			List<Poem> poemSorted = dtaPoems.getContent().getPoem().stream().sorted(Comparator.comparing(poem -> (LocalDate) poem.getDate().getValue())).collect(Collectors.toList());
			dtaPoems.getContent().getPoem().clear();
			dtaPoems.getContent().getPoem().addAll(poemSorted);


			logger.info("reading template file.");

			Configuration tplConfig = new Configuration(Configuration.VERSION_2_3_25);
			tplConfig.setDefaultEncoding(StandardCharsets.UTF_8.name());
			tplConfig.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			tplConfig.setLogTemplateExceptions(false);

			Path pathTemplateFile = Paths.get(theTemplateFile);
			tplConfig.setDirectoryForTemplateLoading(pathTemplateFile.getParent().toFile());
			Template tplDocument = tplConfig.getTemplate(pathTemplateFile.getFileName().toString());


			logger.info("filling and writing poem file.");

			Path pathOutputFile = Paths.get(theOutputFile);
			try (Writer wrtFile = new OutputStreamWriter(new FileOutputStream(pathOutputFile.toFile()), StandardCharsets.UTF_8)) {
				tplDocument.process(dtaPoems, wrtFile);
			}


		} catch (EdgeUtilsException | IOException | TemplateException e) {
			logger.error(e);
		}

		logger.info("stop");

	}

}

/* EOF */
