pipeline {
    agent any
    stages {
        stage("Build") {
            steps {
                echo 'Building...'
                // Si quieres algo más significativo en este paso, puedes agregar el comando para construir el proyecto con Maven
                // ejemplo: sh 'mvn clean install'
            }
        }
        
        stage("Test") {
            steps {
                echo 'Running tests...'
                // Aquí podrías agregar comandos de prueba, como: sh 'mvn test'
            }
        }
        
        stage("Deploy") {
            steps {
                echo 'Deploying...'
                // Aquí puedes agregar el comando de despliegue si es necesario, como: sh './deploy.sh'
            }
        }
    }
}
