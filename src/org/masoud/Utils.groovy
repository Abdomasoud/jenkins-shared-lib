package org.masoud

class Utils implements Serializable {
    def steps
    Utils(steps) { this.steps = steps }
    void log(String msg) { steps.echo "[shared-lib] ${msg}" }
}