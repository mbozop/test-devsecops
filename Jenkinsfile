pipeline {
    agent any
    environment {
        // Variable de entorno requerida para Semgrep Cloud
        SEMGREP_APP_TOKEN = credentials('SEMGREP_APP_TOKEN')
    }
    stages {
        stage('Semgrep-Scan') {
            steps {
                bat '''
                docker pull returntocorp/semgrep &&
                docker run ^
                -e SEMGREP_APP_TOKEN=%SEMGREP_APP_TOKEN% ^
                -v "%cd%:%cd%" --workdir "%cd%" ^
                returntocorp/semgrep semgrep ci
                '''
            }
        }
    }
}
