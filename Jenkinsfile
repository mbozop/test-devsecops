pipeline {
    agent any
    environment {
        SEMGREP_APP_TOKEN = credentials('SEMGREP_APP_TOKEN')
    }
    stages {
        stage('Nuclei-Scan') {
            steps {
                bat '''
                docker pull projectdiscovery/nuclei ^
                && docker run ^
                -v "%cd%:/workspace" ^
                --workdir /workspace ^
                projectdiscovery/nuclei -t /nuclei-templates -silent
                '''
            }
        }
    }
}
