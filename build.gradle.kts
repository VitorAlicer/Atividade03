plugins {
	java
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "br.org.fundatec.lpIII"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	runtimeOnly("com.mysql:mysql-connector-j")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.apache.httpcomponents.client5:httpclient5:5.3.1")
	implementation("com.fasterxml.jackson.core:jackson-core:2.17.0")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.17.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
