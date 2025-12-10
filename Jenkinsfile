pipeline {
    agent any

    tools {
        maven 'Maven 3.9.11'
        jdk 'jdk17'
    }
    environment {
        JAVA_HOME = "C:\\Program Files\\OpenJDK17U-jdk_x64_windows_hotspot_17.0.10_7"
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"

        M2_REPO = "C:\\Users\\kwardzinska\\.m2\\repository"
        ASPECTJ_AGENT = "${M2_REPO}\\org\\aspectj\\aspectjweaver\\1.9.4\\aspectjweaver-1.9.4.jar"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/kari90/jenkins.git'
            }
        }

      stage('Build') {
              steps {
                  bat 'mvn -version'
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






















pipeline {
    agent any

    environment {
        //Twoja ścieżka do Javy, zmieniłam na 17/ jak chcesz możesz zostawic 8
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-17"
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://gitlab.com/MadlenQA/my_project_selenide.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Unit Tests') {
            steps {
                bat 'mvn test'
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
                // Przykład lokalnego deploy
                bat '''
                copy target\\your-app.jar C:\\Apps\\your-app.jar
                start java -jar C:\\Apps\\your-app.jar
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













pipeline {
    agent any

    environment {
        JAVA_HOME = "/usr/lib/jvm/java-8-openjdk"
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://gitlab.com/MadlenQA/my_project_selenide.git'
            }
        }

        stage('Build') {
            steps {
                // Budowanie projektu Maven
                sh 'mvn clean compile'
            }
        }

        stage('Run Unit Tests') {
            steps {
                // Uruchamianie testów TestNG przez Maven
                sh 'mvn test'
            }
            post {
                always {
                    // Publikowanie wyników testów w Jenkinsie
                    junit '**/target/surefire-reports/*.xml'
                    // Publikowanie raportów Allure
                    allure([
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                // Deploy na serwer (przykładowy)
                sh '''
                scp target/your-app.jar user@your-server:/opt/apps/
                ssh user@your-server "systemctl restart your-app.service"
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
