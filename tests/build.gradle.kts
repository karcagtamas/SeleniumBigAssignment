plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:33.0.0-jre")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter"){
        exclude(group = "org.hamcrest")
    }

    testImplementation("org.seleniumhq.selenium:selenium-java:2.52.0")
    testImplementation("org.seleniumhq.selenium:selenium-chrome-driver:3.141.59")

    testImplementation("org.hamcrest:hamcrest-library:1.3")
    testImplementation("org.slf4j:slf4j-simple:1.7.9")

}

tasks.test {
    useJUnitPlatform()
}
