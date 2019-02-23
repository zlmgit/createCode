package CreateCode;

import org.junit.Test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CreateCode {
	@Test
	public void testGenerator() {
		System.out.println("自动生成开始");
		// 1. 全局配置
		GlobalConfig config = new GlobalConfig();
		config.setActiveRecord(true) // 是否支持AR模式
				.setAuthor("zlm") // 作者
				
				.setOutputDir("D:\\develop\\eclipse-workspaceqf3\\CreateCode\\src\\main\\java") // 生成路径
				.setFileOverride(false) // 文件覆盖
				.setIdType(IdType.AUTO) // 主键策略
				.setServiceName("%sService") // 设置生成的service接口的名字的首字母是否为I
				// IEmployeeService
				.setBaseResultMap(true).setBaseColumnList(true);
		
		//2. 数据源配置
		DataSourceConfig  dsConfig  = new DataSourceConfig();
		dsConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
				.setDriverName("com.mysql.jdbc.Driver")
				.setUrl("jdbc:mysql://127.0.0.1:3306/easyshopdb?useUnicode=true&characterEncoding=utf8")
				.setUsername("root")
				.setPassword("123456");
		
		//3. 策略配置
		StrategyConfig stConfig = new StrategyConfig();
		stConfig.setCapitalMode(true) //全局大写命名
						.setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
						.setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
						.setTablePrefix("tb_")						
						//.setTableFillList(Arrays.asList(new String("tb_specification,tb_specification_option"))));
						.setInclude("tb_type_template");  // 生成的表
		
		//4. 包名策略配置 
		PackageConfig pkConfig = new PackageConfig();
		pkConfig.setParent("com.easyshop")
						.setMapper("mapper")
						.setService("service")
						.setController("controller")
						.setEntity("pojo")
						.setXml("mapper");

		//5. 整合配置
		AutoGenerator  ag = new AutoGenerator();
		ag.setGlobalConfig(config)
				  .setDataSource(dsConfig)
				  .setStrategy(stConfig)
				  .setPackageInfo(pkConfig);
		//6. 执行
		ag.execute();
		System.out.println("自动生成完成");
	}
}
