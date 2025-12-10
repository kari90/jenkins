pipeline {
    agent any

    tools {
        jdk 'jdk17'
        maven 'Maven 3.9.11'
    }

    environment {
   JAVA_HOME = "C:/Program Files/OpenJDK17U-jdk_x64_windows_hotspot_17.0.10_7"
   M2_HOME = "C:/Program Files/Apache/apache-maven-3.9.11"
   PATH = "${JAVA_HOME}/bin;${M2_HOME}/bin;${env.PATH}"

        M2_REPO = "C:\\Users\\kwardzinska\\.m2\\repository"
        // AspectJ agent
        ASPECTJ_AGENT = "${M2_REPO}\\org\\aspectj\\aspectjweaver\\1.9.4\\aspectjweaver-1.9.4.jar"

    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/kari90/jenkins.git'
                 credentialsId: 'github-token'
            }
        }
        stage('Verify Maven') {
            steps {
                bat "mvn -version"
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }
        stage('Run Unit Tests') {
            steps {
                bat "mvn test -DargLine=\"-javaagent:${ASPECTJ_AGENT}\""
            }
            post {
                always {
                    junit '**\\target\\surefire-reports\\*.xml'
                    allure([
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target\\allure-results']]
                    ])
                }
            }
        }
        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }
        stage('Deploy') {
            steps {
                bat '''
                REM Kopiowanie JAR do lokalnego folderu
                copy target\\my-project-1.0-SNAPSHOT.jar C:\\Users\\kwardzinska\\Apps\\my_project_selenide.jar

                REM Uruchomienie aplikacji w nowym oknie
                start java -jar C:\\Users\\kwardzinska\\Apps\\my_project_selenide.jar
                '''
            }
        }
    }
    post {
        success {
            echo 'Pipeline zakończony sukcesem!'
        }
        failure {
            echo 'Pipeline nie powiódł się.'
        }
    }
}
