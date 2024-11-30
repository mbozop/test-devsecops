pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/mbozop/test-devsecops.git',
                    credentialsId: 'your-credentials-id'
            }
        }

        stage('Run Semgrep') {
            steps {
                echo 'Running Semgrep...'
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
