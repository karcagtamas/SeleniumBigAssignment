plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:33.0.0-jre")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter"){
        exclude(group = "org.hamcrest")
    }

    testImplementation("org.seleniumhq.selenium:selenium-java:4.20.0")
    testImplementation("org.seleniumhq.selenium:selenium-chrome-driver:4.20.0")

    testImplementation("org.hamcrest:hamcrest-library:1.3")
    testImplementation("org.slf4j:slf4j-simple:1.7.9")

}

tasks.test {
    useJUnitPlatform()
}
