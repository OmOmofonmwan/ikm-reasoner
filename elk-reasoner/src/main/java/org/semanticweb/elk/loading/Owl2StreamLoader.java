
package org.semanticweb.elk.loading;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.semanticweb.elk.owl.parsing.Owl2ParserFactory;
import org.semanticweb.elk.util.concurrent.computation.InterruptMonitor;

/**
 * A {@link AxiomLoader} which loads ontology from streams (e.g., backed by
 * files or strings) using a given {@link Owl2ParserFactory}
 * 
 * @author "Yevgeny Kazakov"
 * @author Peter Skocovsky
 */
public class Owl2StreamLoader extends Owl2ParserLoader implements AxiomLoader {

	private final InputStream stream_;

	private Owl2StreamLoader(final InterruptMonitor interrupter,
			Owl2ParserFactory parserFactory, InputStream stream) {
		super(interrupter, parserFactory.getParser(stream));
		this.stream_ = stream;
	}

	@Override
	public void disposeParserResources() {
		super.disposeParserResources();
		try {
			stream_.close();
		} catch (IOException e) {
			exception = new ElkLoadingException(
					"Cannot close the input stream!", e);
		}
	}

	public static class Factory implements AxiomLoader.Factory {

		private final Owl2ParserFactory parserFactory_;
		private final InputStream stream_;

		public Factory(final Owl2ParserFactory parserFactory,
				final InputStream stream) {
			this.parserFactory_ = parserFactory;
			this.stream_ = stream;
		}

		public Factory(final Owl2ParserFactory parserFactory, final File file)
				throws FileNotFoundException {
			this(parserFactory, new FileInputStream(file));
		}

		public Factory(final Owl2ParserFactory parserFactory,
				final String text) {
			this(parserFactory, new ByteArrayInputStream(text.getBytes()));
		}

		@Override
		public Owl2StreamLoader getAxiomLoader(
				final InterruptMonitor interrupter) {
			return new Owl2StreamLoader(interrupter, parserFactory_, stream_);
		}

	}

}
