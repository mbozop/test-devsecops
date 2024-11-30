pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                // Clona el código desde el repositorio
                git 'https://github.com/mbozop/test-devsecops.git'
            }
        }

        stage('Run Semgrep') {
            steps {
                echo 'Running Semgrep for static code analysis...'
                // Ejecuta Semgrep con las reglas configuradas
                sh '''
                pip install semgrep
                semgrep --config=auto --json --output semgrep-report.json || true
                '''
            }
        }

        stage('Publish Reports') {
            steps {
                echo 'Publishing Semgrep report...'
                archiveArtifacts artifacts: 'semgrep-report.json', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution complete.'
        }
    }
}
