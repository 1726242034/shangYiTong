import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;


public class test {


	//	代码生成
	@Test
	public void testGenerator() {

//		全局策略配置
		GlobalConfig globalConfig = new GlobalConfig();
		globalConfig.setActiveRecord(true)            // 是否支持AR模式
				.setAuthor("xuJunNan")        // 作者
				.setOutputDir("C:\\Users\\xu172\\Desktop\\lx\\尚医通\\yygh-parent\\service\\service-hosp")    // 生成路径
				.setFileOverride(true)        // 文件覆盖
				.setIdType(IdType.AUTO)        // 主键策略
				.setServiceName("%sService")        // service的命名方式( %s是占位符 )
				.setControllerName("%sController")    // controller的命名方式( %s是占位符 )
				.setBaseResultMap(true)
				.setBaseColumnList(true);


//		数据源配置，通过该配置，指定需要生成代码的具体数据库
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig
				.setDbType(DbType.MYSQL)    // 设置数据库类型
				.setDriverName("com.mysql.jdbc.Driver")    // 数据库驱动
				.setUrl("jdbc:mysql://192.168.32.9:3306/yygh_hosp") // 数据库连接地址
				.setUsername("root")        // 数据库用户
				.setPassword("love500");    // 数据库密码


//		数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表
		StrategyConfig strategyConfig = new StrategyConfig();
		strategyConfig
				.setCapitalMode(true)            // 是否大写命名
				.setNaming(NamingStrategy.underline_to_camel);    // 数据库表映射到实体的命名策略


//		包名配置，通过该配置，指定生成代码的包路径
		PackageConfig packageConfig = new PackageConfig();
		packageConfig
				.setParent("com.xu.serviceHosp")    // 生成的代码的位置
				.setMapper("mapper")            // 生成的mapper文件的包名
				.setService("service")            // 生成的Service接口的包名
				.setController("controller")    // 生成的Controller文件的包名
				.setEntity("dao")            // 生成的Entity类的包名
				.setXml("mapper");                // 生成的xml文件的包名


//		整合配置, 把所有配置对象整合到一起
		new AutoGenerator()
				.setDataSource(dataSourceConfig)
				.setStrategy(strategyConfig)
				.setPackageInfo(packageConfig)
				.setGlobalConfig(globalConfig)
				.execute();            // 执行

	}

}
