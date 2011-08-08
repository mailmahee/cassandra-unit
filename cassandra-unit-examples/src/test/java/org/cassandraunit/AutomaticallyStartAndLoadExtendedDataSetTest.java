package org.cassandraunit;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.cassandraunit.dataset.IDataSet;
import org.cassandraunit.dataset.xml.ClassPathXmlDataSet;
import org.junit.Test;

public class AutomaticallyStartAndLoadExtendedDataSetTest extends AbstractCassandraUnit4TestCase {

	@Override
	public IDataSet getDataSet() {
		return new ClassPathXmlDataSet("extendedDataSet.xml");
	}

	@Test
	public void shouldHaveLoadAnExtendDataSet() throws Exception {
		assertThat(getKeyspace(), notNullValue());
		assertThat(getKeyspace().getKeyspaceName(), is("otherKeyspaceName"));
	}

}
