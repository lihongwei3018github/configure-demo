还值得一提的是，YAML 文件不支持@PropertySource注释，所以如果我们需要使用此注释，它会限制我们使用属性文件。

在Spring Boot中，配置文件的加载和优先级是一个重要的概念，它决定了当存在多个相同配置时，哪个配置会被优先使用。以下是关于properties、yml、命令行参数和外部配置文件的优先级解析：

1. **命令行参数**：
    - 优先级最高。它们可以通过在启动应用程序时添加`--key=value`的形式来设置。
    - 例如，`java -jar myapp.jar --server.port=8081`会设置服务器端口为8081，覆盖任何其他配置文件中的同名设置。

2. **外部配置文件**（按照从高到低的优先级排序）：
    - 文件在jar包外部的指定配置文件（如`application-prod.properties`或`application-prod.yml`），这些文件通常用于特定环境配置（如开发、测试、生产）。
    - 文件在jar包外部的普通配置文件（如`application.properties`或`application.yml`）。
    - 文件在classpath的`/config/`目录下的配置文件。
    - 文件在classpath根目录下的配置文件。
    - 对于每个位置，`.properties`文件的优先级高于`.yml`和`.yaml`文件（当它们存在于同一位置且内容冲突时）。

3. **系统环境变量**：
    - 通过`-Dkey=value`形式设置的Java系统属性，其优先级低于命令行参数但高于配置文件。
    - 例如，`java -Dserver.port=8080 -jar myapp.jar`将使用系统属性设置服务器端口，除非它被命令行参数覆盖。

4. **默认属性**：
    - Spring Boot提供了一些默认属性，这些属性的优先级最低，可以在没有其他配置时作为回退选项。

5. **properties与yml/yaml的优先级**：
    - 在同一级目录下，如果存在冲突的配置，`.properties`文件的优先级高于`.yml`和`.yaml`文件。

综上所述，Spring Boot配置文件的加载优先级大致可以归纳为：

* 命令行参数（最高）
* 文件在jar包外部的指定配置文件（如`application-{profile}.properties`或`application-{profile}.yml`）
* 文件在jar包外部的普通配置文件（如`application.properties`或`application.yml`）
* classpath下的`/config/`目录中的配置文件
* classpath根目录下的配置文件
* 系统环境变量（通过`-D`设置）
* 默认属性（最低）

在每种配置文件中，`.properties`格式的优先级又高于`.yml`和`.yaml`格式。希望这可以清晰地解答你的问题。