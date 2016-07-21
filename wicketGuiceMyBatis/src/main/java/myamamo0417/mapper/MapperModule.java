package myamamo0417.mapper;

import java.util.Properties;

import com.google.inject.name.Names;

import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.mybatis.guice.datasource.helper.JdbcHelper;

public class MapperModule extends MyBatisModule {

    protected void initialize() {
	install(JdbcHelper.H2_IN_MEMORY_NAMED);

	bindDataSourceProviderType(PooledDataSourceProvider.class);
	bindTransactionFactoryType(JdbcTransactionFactory.class);
	
	Properties properties = new Properties();
	properties.setProperty("mybatis.environment.id", "develop");
	properties.setProperty("JDBC.schema", "./myamamo0417");
	Names.bindProperties(binder(), properties);

	addMapperClass(MessageMapper.class);
    }

}

    