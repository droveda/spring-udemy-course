## Some annotations
* @Primary  -> A bean should be given preference when multiple candidates are qualified
* @Qualifier("newAddress") -> A specific bean should be auto-wired (name of the bean can be used as qualifier)
  * Remember @Qualifier has higher prioriry then @Primary
* @Component : An instance of class will be managed by Spring Framework
* @ComponentScan : How does spring find component classes
* @Autowired
* @Configuration : indicates that a class declares one or more @Bean and may be processed by the spring container to generate bean definitions
* @Service
* @Controller
* @Repository
* @Lazy : Indicates that a beans has to be lazy initialized
* @Scope
  * prototype - New bean whenever requested
  * @Scope("prototype")
  * @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  * @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS) (ver exemplo JDBCConnection.java)
* @PostConstruct
* @PreDestroy
* @Named : CDI it is similar to @Component
* @Inject : similar to @Autowired